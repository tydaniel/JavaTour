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
import net.tydaniel.model.Role;
import net.tydaniel.service.IRoleService;

/**
 * <p>
 * 角色  前端控制器
 * </p>
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    
    @Autowired private IRoleService roleService;
    
    @GetMapping("/manager")
    public String manager() {
        return "admin/role/roleList";
    }


    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Role role, Integer page, Integer rows, String sort,String order) {
        EntityWrapper<Role> ew = new EntityWrapper<Role>();
        ew.setEntity(role);
        Page<Role> pages = getPage(page, rows, sort, order);
        pages = roleService.selectPage(pages,ew);
        return pageToPageInfo(pages);
    }
    
    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/role/roleAdd";
    }

    /**
     * 添加
     * @param 
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(Role role) {
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        role.setDeleteFlag(0);
        boolean b = roleService.insert(role);
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
        Role role = new Role();
        role.setId(id);
        role.setUpdateTime(new Date());
        role.setDeleteFlag(1);
        boolean b = roleService.updateById(role);
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
        Role role = roleService.selectById(id);
        model.addAttribute("role", role);
        return "admin/role/roleEdit";
    }

    /**
     * 编辑
     * @param 
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(Role role) {
        role.setUpdateTime(new Date());
        boolean b = roleService.updateById(role);
        if (b) {
            return renderSuccess("编辑成功！");
        } else {
            return renderError("编辑失败！");
        }
    }
    
}
