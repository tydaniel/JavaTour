package net.tydaniel.service.impl;

import net.tydaniel.model.Book;
import net.tydaniel.mapper.BookMapper;
import net.tydaniel.service.IBookService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图书 服务实现类
 * </p>
 *
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
	
}
