package com.mystudy.service.impl;

import com.mystudy.dao.GoodsDao;
import com.mystudy.dao.SaleDao;
import com.mystudy.entity.Goods;
import com.mystudy.entity.Sale;
import com.mystudy.exception.NotEnoughException;
import com.mystudy.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("service")
public class MyServiceImpl implements MyService {

    @Autowired
    private SaleDao saleDao;
    @Autowired
    private GoodsDao goodsDao;

    /**
     * rollbackFor：表示发生指定的异常一定回滚
     *  处理逻辑：
     *          1.spring框架会首先检查方法抛出的异常是不是在rollbaFor属性值中
     *            如果在属性值中，不管是什么类型的异常，一定回滚。
     *          2.如果抛出的异常不在rollbakFor列表中，spring框架会判断异常是否为运行时异常。
     *            如果是，一定会回滚。
     */
    /*@Transactional(
            //传播行为
            propagation = Propagation.REQUIRED,
            //隔离级别
            isolation = Isolation.DEFAULT,
            //只读为false
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,NotEnoughException.class
            }
    )*/
    //使用的是事务控制的默认值，默认的传播行为是REQUIRED，默认的隔离级别是DEFAULT，默认抛出运行时异常回滚事务
    @Transactional
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
