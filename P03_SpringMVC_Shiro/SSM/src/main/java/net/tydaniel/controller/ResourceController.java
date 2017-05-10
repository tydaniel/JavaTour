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
import net.tydaniel.model.Resource;
import net.tydaniel.service.IResourceService;

/**
 * <p>
 * 资源  前端控制器
 * </p>
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    
    @Autowired private IResourceService resourceService;
    
    @GetMapping("/manager")
    public String manager() {
        return "admin/resource/resourceList";
    }


    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Resource resource, Integer page, Integer rows, String sort,String order) {
        EntityWrapper<Resource> ew = new EntityWrapper<Resource>();
        ew.setEntity(resource);
        Page<Resource> pages = getPage(page, rows, sort, order);
        pages = resourceService.selectPage(pages,ew);
        return pageToPageInfo(pages);
    }
    
    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/resource/resourceAdd";
    }

    /**
     * 添加
     * @param 
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(Resource resource) {
        resource.setCreateTime(new Date());
        resource.setUpdateTime(new Date());
        resource.setDeleteFlag(0);
        boolean b = resourceService.insert(resource);
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
        Resource resource = new Resource();
        resource.setId(id);
        resource.setUpdateTime(new Date());
        resource.setDeleteFlag(1);
        boolean b = resourceService.updateById(resource);
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
        Resource resource = resourceService.selectById(id);
        model.addAttribute("resource", resource);
        return "admin/resource/resourceEdit";
    }

    /**
     * 编辑
     * @param 
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(Resource resource) {
        resource.setUpdateTime(new Date());
        boolean b = resourceService.updateById(resource);
        if (b) {
            return renderSuccess("编辑成功！");
        } else {
            return renderError("编辑失败！");
        }
    }
    
}
