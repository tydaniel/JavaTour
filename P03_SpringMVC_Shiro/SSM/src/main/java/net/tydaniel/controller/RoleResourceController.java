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
import net.tydaniel.model.RoleResource;
import net.tydaniel.service.IRoleResourceService;

/**
 * <p>
 * 角色资源  前端控制器
 * </p>
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Controller
@RequestMapping("/roleResource")
public class RoleResourceController {
    
    @Autowired private IRoleResourceService roleResourceService;
    
    @GetMapping("/manager")
    public String manager() {
        return "admin/roleResource/roleResourceList";
    }


    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(RoleResource roleResource, Integer page, Integer rows, String sort,String order) {
        EntityWrapper<RoleResource> ew = new EntityWrapper<RoleResource>();
        ew.setEntity(roleResource);
        Page<RoleResource> pages = getPage(page, rows, sort, order);
        pages = roleResourceService.selectPage(pages,ew);
        return pageToPageInfo(pages);
    }
    
    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/roleResource/roleResourceAdd";
    }

    /**
     * 添加
     * @param 
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(RoleResource roleResource) {
        roleResource.setCreateTime(new Date());
        roleResource.setUpdateTime(new Date());
        roleResource.setDeleteFlag(0);
        boolean b = roleResourceService.insert(roleResource);
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
        RoleResource roleResource = new RoleResource();
        roleResource.setId(id);
        roleResource.setUpdateTime(new Date());
        roleResource.setDeleteFlag(1);
        boolean b = roleResourceService.updateById(roleResource);
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
        RoleResource roleResource = roleResourceService.selectById(id);
        model.addAttribute("roleResource", roleResource);
        return "admin/roleResource/roleResourceEdit";
    }

    /**
     * 编辑
     * @param 
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(RoleResource roleResource) {
        roleResource.setUpdateTime(new Date());
        boolean b = roleResourceService.updateById(roleResource);
        if (b) {
            return renderSuccess("编辑成功！");
        } else {
            return renderError("编辑失败！");
        }
    }
    
}
