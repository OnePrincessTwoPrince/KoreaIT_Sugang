package com.koreait.koreaitsugang.repository;


import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SugangRepository {

    public List<String> searchCategory();

}
