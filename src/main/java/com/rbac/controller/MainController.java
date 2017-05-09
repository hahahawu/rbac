package com.rbac.controller;

import com.rbac.entity.*;
import com.rbac.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by hahah on 2017/5/4.
 */
@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    PrivilegeRepository privilegeRepository;
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    ElementRepository elementRepository;

    @RequestMapping("/login")
    public ModelAndView login(ModelMap modelMap){
        modelMap.addAttribute("status","login");
        return new ModelAndView("login",modelMap);
    }

    @RequestMapping("/test")
    public ModelAndView testPrivilege(HttpSession session){
        ModelMap modelMap = (ModelMap)session.getAttribute("modelMap");
        ArrayList rolelist = (ArrayList) (modelMap).get("rolelist");
        if (rolelist.contains("政府工作人员")){
            modelMap.addAttribute("privilege","accept");
        }
        else modelMap.addAttribute("privilege","reject");
        return new ModelAndView("home",modelMap);
    }

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public ModelAndView home(@RequestParam("username") String username,
                             @RequestParam("userpassword") String userpassword ,
                             ModelMap modelMap,HttpSession session){
        UserEntity user = userRepository.findUserEntityByUsername(username);
        if(user!=null&&user.getPassword().equals(userpassword)){
            Set<User2RoleEntity> userRoleSet = user.getUser2RoleEntitySet();
            Set<User2GroupEntity> user2GroupEntitySet = user.getUser2GroupEntitySet();
            ArrayList grouplist = getGroupList(user2GroupEntitySet);
            ArrayList rolelist = getUserRoles(userRoleSet,grouplist);
            ArrayList privileges = getPrivileges(rolelist);
            ArrayList elements = getElements(privileges);
            ArrayList operations = getOperations(privileges);
            modelMap.addAttribute("privilege","normal");
            modelMap.addAttribute("rolelist",rolelist);
            modelMap.addAttribute("grouplist",grouplist);
            modelMap.addAttribute("elements",elements);
            modelMap.addAttribute("operations",operations);
            modelMap.addAttribute("user",user);
            session.setAttribute("modelMap",modelMap);
            return new ModelAndView("home",modelMap);
        }
        else{
            modelMap.addAttribute("status","fail");
            return new ModelAndView("login",modelMap);
        }
    }

    private ArrayList getOperations(ArrayList<Integer> privileges) {
        ArrayList<String> operations = new ArrayList<String>();
        List<OperationEntity> operationEntities;
        for (Integer i:privileges){
            operationEntities = operationRepository.findOperationEntitiesByPrivilegeid(i);
            for(OperationEntity operationEntity:operationEntities){
                if (!operations.contains(operationEntity.getOperationname())){
                    operations.add(operationEntity.getOperationname());
                }
            }
        }
        return operations;
    }

    private ArrayList getElements(ArrayList<Integer> privileges) {
        ArrayList<String> elements = new ArrayList<String>();
        List<ElementsinpageEntity> elementsEntities;
        for(Integer i:privileges){
            elementsEntities = elementRepository.findElementsinpageEntitiesByPrivilegeid(i);
            for (ElementsinpageEntity elementsinpageEntity:elementsEntities){
                if(!elements.contains(elementsinpageEntity.getElementname()))
                    elements.add(elementsinpageEntity.getElementname());
            }
        }
        return elements;
    }

    private ArrayList getPrivileges(ArrayList<String> rolelist) {
        ArrayList<Integer> privileges = new ArrayList<Integer>();
        List<PrivilegeEntity> privilegeEntities;
        for (String rolename : rolelist){
            privilegeEntities = privilegeRepository.findPrivilegeEntitiesByRolename(rolename);
            for(PrivilegeEntity privilegeEntity:privilegeEntities)
                privileges.add(privilegeEntity.getPrivilegeid());
        }
        return privileges;
    }

    private ArrayList getGroupList(Set<User2GroupEntity> user2GroupEntitySet) {
        ArrayList<String> grouplist = new ArrayList<String>();
        for (User2GroupEntity user2GroupEntity:user2GroupEntitySet){
            grouplist.add(user2GroupEntity.getUgusergroupEntity().getUsergroupname());
        }
        return grouplist;
    }

    private ArrayList getUserRoles(Set<User2RoleEntity> userRoleSet, ArrayList<String> grouplist) {
        ArrayList<String> rolelist = new ArrayList<String>();
        for(User2RoleEntity user2RoleEntity : userRoleSet){
            rolelist.add(user2RoleEntity.getRoleEntity().getRolename());
        }
        for(String str : grouplist){
            UsergroupEntity usergroupEntity = groupRepository.findUsergroupEntityByUsergroupname(str);
            Set<Usergroup2RoleEntity> usergroup2RoleEntitySet = usergroupEntity.getUsergroup2RoleEntitySet();
            for(Usergroup2RoleEntity usergroup2RoleEntity:usergroup2RoleEntitySet)
                rolelist.add(usergroup2RoleEntity.getGrroleEntity().getRolename());
        }
        return rolelist;
    }

}
