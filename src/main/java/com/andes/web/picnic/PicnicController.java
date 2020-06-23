package com.andes.web.picnic;

import com.andes.web.mappers.PicnicMapper;
import com.andes.web.proxy.Box;
import com.andes.web.proxy.Pager;
import com.andes.web.proxy.Proxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;


@RestController
@RequestMapping("/picnic")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class PicnicController {
    @Autowired PicnicMapper picnicMapper;
    @Autowired Box<Object> box;
    @Autowired Proxy pxy;
    @Autowired Pager pager;

    static Logger logger = LoggerFactory.getLogger(PicnicController.class);

    @GetMapping("/findSome/{searchWord}/{pageNum}")
    public Map<?,?> findSome(@PathVariable("searchWord") String searchWord,
                         @PathVariable("pageNum") String pageNum){
        logger.info("list()");

        pager.setPageNow(pxy.integer(pageNum));
        pager.setBlockSize(5);
        pager.setPageSize(10);
        pager.setSearchWord(searchWord);
        pager.paging(picnicMapper.searchCount(searchWord));



        Function<Pager, List<PicnicDTO>> f = p -> picnicMapper.selectPicnics(p);
        List<PicnicDTO> l = f.apply(pager);
        box.clear();
        box.put("pager", pager);
        box.put("list", l);

        return box.get();
    }

    @GetMapping("/findAll/{pageNum}")
    public Map<?,?> findAll(@PathVariable String pageNum) {
        logger.info("findAll()");

        pager.setPageNow(pxy.integer(pageNum));
        pager.setBlockSize(5);
        pager.setPageSize(10);
        pager.paging(picnicMapper.count());

        Function<Pager, List<PicnicDTO>> f = p -> picnicMapper.selectAll(p);
        List<PicnicDTO> l = f.apply(pager);
        box.clear();
        box.put("pager", pager);
        box.put("list", l);
        return box.get();
    }


}
