package com.jerry.springboot_swagger.controller;

import com.jerry.springboot_swagger.entity.Book;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {
    Map<Long, Book> bookMap= Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取图书",notes = "获取图书")
    @RequestMapping(value = "",method =RequestMethod.GET)
    public List<Book> getBook()
    {
        List<Book> books=new ArrayList<>(bookMap.values());
        return books;
    }

    @ApiOperation(value = "创建图书",notes = "创建图书")
    @ApiImplicitParam(name = "book",value = "图书实体",required=true,dataType = "Book")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postBook(@RequestBody Book book)
    {
        bookMap.put(book.getId(),book);
        return "success";
    }
    @ApiOperation(value = "更新信息",notes = "根据id来更新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "ID",required = true,dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "book",value = "图书实体book",required = true,dataType = "Book")
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putUser(@PathVariable("id")Long id,@RequestBody Book book)
    {
        Book book1=bookMap.get(id);
        book1.setName(book.getName());
        book.setPrice(book.getPrice());
        bookMap.put(id,book1);
        return "success";
    }
    @ApiOperation(value = "获取图书信息",notes = "根据id来获取消息")
    @ApiImplicitParam(name = "id",value = "ID",required = true,dataType = "Long",paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id)
    {
        return bookMap.get(id);
    }
    @ApiOperation(value = "删除图书",notes = "根据id来删除图书")
    @ApiImplicitParam(name = "id",value = "图书id",required = true,dataType = "Long",paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id)
    {
        bookMap.remove(id);
        return "success";
    }
    @ApiIgnore
    @RequestMapping(value = "/swagger2",method = RequestMethod.GET)
    public String json()
    {
        return "Hello Swagger";
    }
}
