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
import net.tydaniel.model.Organization;
import net.tydaniel.service.IOrganizationService;

/**
 * <p>
 * 组织机构  前端控制器
 * </p>
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
    
    @Autowired private IOrganizationService organizationService;
    
    @GetMapping("/manager")
    public String manager() {
        return "admin/organization/organizationList";
    }


    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Organization organization, Integer page, Integer rows, String sort,String order) {
        EntityWrapper<Organization> ew = new EntityWrapper<Organization>();
        ew.setEntity(organization);
        Page<Organization> pages = getPage(page, rows, sort, order);
        pages = organizationService.selectPage(pages,ew);
        return pageToPageInfo(pages);
    }
    
    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/organization/organizationAdd";
    }

    /**
     * 添加
     * @param 
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(Organization organization) {
        organization.setCreateTime(new Date());
        organization.setUpdateTime(new Date());
        organization.setDeleteFlag(0);
        boolean b = organizationService.insert(organization);
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
        Organization organization = new Organization();
        organization.setId(id);
        organization.setUpdateTime(new Date());
        organization.setDeleteFlag(1);
        boolean b = organizationService.updateById(organization);
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
        Organization organization = organizationService.selectById(id);
        model.addAttribute("organization", organization);
        return "admin/organization/organizationEdit";
    }

    /**
     * 编辑
     * @param 
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(Organization organization) {
        organization.setUpdateTime(new Date());
        boolean b = organizationService.updateById(organization);
        if (b) {
            return renderSuccess("编辑成功！");
        } else {
            return renderError("编辑失败！");
        }
    }
    
}
