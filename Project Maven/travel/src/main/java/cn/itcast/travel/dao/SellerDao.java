package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

public interface SellerDao {
    Seller findOneBySid(int sid);
}