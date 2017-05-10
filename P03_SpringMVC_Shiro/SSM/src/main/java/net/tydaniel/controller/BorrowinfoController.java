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
import net.tydaniel.model.Borrowinfo;
import net.tydaniel.service.IBorrowinfoService;

/**
 * <p>
 * 借阅信息明细  前端控制器
 * </p>
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Controller
@RequestMapping("/borrowinfo")
public class BorrowinfoController {
    
    @Autowired private IBorrowinfoService borrowinfoService;
    
    @GetMapping("/manager")
    public String manager() {
        return "admin/borrowinfo/borrowinfoList";
    }


    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Borrowinfo borrowinfo, Integer page, Integer rows, String sort,String order) {
        EntityWrapper<Borrowinfo> ew = new EntityWrapper<Borrowinfo>();
        ew.setEntity(borrowinfo);
        Page<Borrowinfo> pages = getPage(page, rows, sort, order);
        pages = borrowinfoService.selectPage(pages,ew);
        return pageToPageInfo(pages);
    }
    
    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/borrowinfo/borrowinfoAdd";
    }

    /**
     * 添加
     * @param 
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(Borrowinfo borrowinfo) {
        borrowinfo.setCreateTime(new Date());
        borrowinfo.setUpdateTime(new Date());
        borrowinfo.setDeleteFlag(0);
        boolean b = borrowinfoService.insert(borrowinfo);
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
        Borrowinfo borrowinfo = new Borrowinfo();
        borrowinfo.setId(id);
        borrowinfo.setUpdateTime(new Date());
        borrowinfo.setDeleteFlag(1);
        boolean b = borrowinfoService.updateById(borrowinfo);
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
        Borrowinfo borrowinfo = borrowinfoService.selectById(id);
        model.addAttribute("borrowinfo", borrowinfo);
        return "admin/borrowinfo/borrowinfoEdit";
    }

    /**
     * 编辑
     * @param 
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(Borrowinfo borrowinfo) {
        borrowinfo.setUpdateTime(new Date());
        boolean b = borrowinfoService.updateById(borrowinfo);
        if (b) {
            return renderSuccess("编辑成功！");
        } else {
            return renderError("编辑失败！");
        }
    }
    
}
