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
import net.tydaniel.model.User;
import net.tydaniel.service.IUserService;

/**
 * <p>
 * 用户  前端控制器
 * </p>
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired private IUserService userService;
    
    @GetMapping("/manager")
    public String manager() {
        return "admin/user/userList";
    }


    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(User user, Integer page, Integer rows, String sort,String order) {
        EntityWrapper<User> ew = new EntityWrapper<User>();
        ew.setEntity(user);
        Page<User> pages = getPage(page, rows, sort, order);
        pages = userService.selectPage(pages,ew);
        return pageToPageInfo(pages);
    }
    
    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/user/userAdd";
    }

    /**
     * 添加
     * @param 
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(User user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setDeleteFlag(0);
        boolean b = userService.insert(user);
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
        User user = new User();
        user.setId(id);
        user.setUpdateTime(new Date());
        user.setDeleteFlag(1);
        boolean b = userService.updateById(user);
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
        User user = userService.selectById(id);
        model.addAttribute("user", user);
        return "admin/user/userEdit";
    }

    /**
     * 编辑
     * @param 
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(User user) {
        user.setUpdateTime(new Date());
        boolean b = userService.updateById(user);
        if (b) {
            return renderSuccess("编辑成功！");
        } else {
            return renderError("编辑失败！");
        }
    }
    
}
