package com.andes.web.proxy;

import com.andes.web.mappers.PicnicMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pager {
    @Autowired PicnicMapper picnicMapper;
    private int rowCount, pageCount, blockCount,
            rowStart, pageStart, prevBlock,
            rowEnd, pageEnd, nextBlock,
            pageSize, blockSize,
            pageNow, blockNow;
    private boolean existPre, existNext;
    private String searchWord;

    public void paging(int count){
        blockNow = pageNow / blockSize;
        rowCount = count;
        rowStart = pageNow * pageSize;
        pageCount = (rowCount % pageSize != 0) ? (rowCount / pageSize +1) :(rowCount / pageSize );
        rowEnd = (pageNow != (pageCount -1)) ? (pageNow+1)*pageSize-1:rowCount-1;
        pageStart = blockNow *  blockSize;
        pageEnd = (blockNow != (blockCount -1)) ? (blockNow+1)*blockSize -1: pageCount - 1;
        blockCount = (pageCount % blockSize != 0) ? pageCount / blockSize +1:pageCount / blockSize ;
        prevBlock = pageStart - blockSize;
        nextBlock = pageStart + blockSize;
        existPre = blockNow!=0;
        existNext = blockNow !=(blockCount-1);
    }
}
