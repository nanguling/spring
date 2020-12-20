package com.mystudy.service.impl;

import com.mystudy.dao.GoodsDao;
import com.mystudy.dao.SaleDao;
import com.mystudy.entity.Goods;
import com.mystudy.entity.Sale;
import com.mystudy.exception.NotEnoughException;
import com.mystudy.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("service")
public class MyServiceImpl implements MyService {

    @Autowired
    private SaleDao saleDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public void buy(Integer gid, Integer nums) {
        System.out.println("========buy方法开始执行========");
        //记录销售记录，向sale表添加数据
        Sale sale = new Sale();
        sale.setGid(gid);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        //更新库存
        Goods good = goodsDao.selectGood(gid);
        if (good == null) {
            //商品不存在
            throw new NullPointerException("编号为："+gid+" 的商品不存在");
        }else if (good.getAmount() < nums) {
            //商品库存不足
            throw new NotEnoughException("编号为："+gid+" 的商品库存不足");
        }
        //更新
        Goods buyGood = new Goods();
        buyGood.setId(gid);
        buyGood.setAmount(nums);
        goodsDao.updateGoods(buyGood);
        System.out.println("========buy方法执行结束========");
    }
}
