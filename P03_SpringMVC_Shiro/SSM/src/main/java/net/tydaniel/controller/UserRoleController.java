package net.tydaniel.controller;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import net.tydaniel.commons.base.BaseController;
import net.tydaniel.commons.utils.PageInfo;
import net.tydaniel.model.UserRole;
import net.tydaniel.service.IUserRoleService;

/**
 * <p>
 * 用户角色  前端控制器
 * </p>
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Controller
@RequestMapping("/userRole")
public class UserRoleController {
    
    @Autowired private IUserRoleService userRoleService;
    
    @GetMapping("/manager")
    public String manager() {
        return "admin/userRole/userRoleList";
    }


    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(UserRole userRole, Integer page, Integer rows, String sort,String order) {
        EntityWrapper<UserRole> ew = new EntityWrapper<UserRole>();
        ew.setEntity(userRole);
        Page<UserRole> pages = getPage(page, rows, sort, order);
        pages = userRoleService.selectPage(pages,ew);
        return pageToPageInfo(pages);
    }
    
    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/userRole/userRoleAdd";
    }

    /**
     * 添加
     * @param 
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(UserRole userRole) {
        userRole.setCreateTime(new Date());
        userRole.setUpdateTime(new Date());
        userRole.setDeleteFlag(0);
        boolean b = userRoleService.insert(userRole);
        if (b) {
            return renderSuccess("添加成功！");
        } else {
            return renderError("添加失败！");
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Object delete(Long id) {
        UserRole userRole = new UserRole();
        userRole.setId(id);
        userRole.setUpdateTime(new Date());
        userRole.setDeleteFlag(1);
        boolean b = userRoleService.updateById(userRole);
        if (b) {
            return renderSuccess("删除成功！");
        } else {
            return renderError("删除失败！");
        }
    }

    /**
     * 编辑
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/editPage")
    public String editPage(Model model, Long id) {
        UserRole userRole = userRoleService.selectById(id);
        model.addAttribute("userRole", userRole);
        return "admin/userRole/userRoleEdit";
    }

    /**
     * 编辑
     * @param 
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(UserRole userRole) {
        userRole.setUpdateTime(new Date());
        boolean b = userRoleService.updateById(userRole);
        if (b) {
            return renderSuccess("编辑成功！");
        } else {
            return renderError("编辑失败！");
        }
    }
    
}
