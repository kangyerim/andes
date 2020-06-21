package com.andes.web.mappers;

import com.andes.web.picnic.PicnicDTO;
import com.andes.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicnicMapper {
    public void insertPicnic(PicnicDTO picnic);

    public List<PicnicDTO> selectPicnics(Pager pager);

    public PicnicDTO selectPicnic();

    public Integer count();

    public List<PicnicDTO> selectAll(Pager p);

    public int searchCount(String searchWord);
}
