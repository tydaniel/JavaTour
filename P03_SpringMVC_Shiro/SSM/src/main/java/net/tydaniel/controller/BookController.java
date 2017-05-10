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
import net.tydaniel.model.Book;
import net.tydaniel.service.IBookService;

/**
 * <p>
 * 图书  前端控制器
 * </p>
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Controller
@RequestMapping("/book")
public class BookController {
    
    @Autowired private IBookService bookService;
    
    @GetMapping("/manager")
    public String manager() {
        return "admin/book/bookList";
    }


    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Book book, Integer page, Integer rows, String sort,String order) {
        EntityWrapper<Book> ew = new EntityWrapper<Book>();
        ew.setEntity(book);
        Page<Book> pages = getPage(page, rows, sort, order);
        pages = bookService.selectPage(pages,ew);
        return pageToPageInfo(pages);
    }
    
    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/book/bookAdd";
    }

    /**
     * 添加
     * @param 
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(Book book) {
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        book.setDeleteFlag(0);
        boolean b = bookService.insert(book);
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
        Book book = new Book();
        book.setId(id);
        book.setUpdateTime(new Date());
        book.setDeleteFlag(1);
        boolean b = bookService.updateById(book);
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
        Book book = bookService.selectById(id);
        model.addAttribute("book", book);
        return "admin/book/bookEdit";
    }

    /**
     * 编辑
     * @param 
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(Book book) {
        book.setUpdateTime(new Date());
        boolean b = bookService.updateById(book);
        if (b) {
            return renderSuccess("编辑成功！");
        } else {
            return renderError("编辑失败！");
        }
    }
    
}
