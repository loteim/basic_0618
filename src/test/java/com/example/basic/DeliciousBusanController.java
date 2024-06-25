package com.example.basic;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.example.basic.model.FavoriteTb;
import com.example.basic.model.ShopTagTb;
import com.example.basic.model.ShopTb;
import com.example.basic.model.TagTb;
import com.example.basic.model.UserTb;
import com.example.basic.repository.FavoriteTbRepository;
import com.example.basic.repository.ShopTagTbRepository;
import com.example.basic.repository.ShopTbRepository;
import com.example.basic.repository.TagTbRepository;
import com.example.basic.repository.UserTbRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class DeliciousBusanController{
    @Autowired TagTbRepository tagTbRepository;
    @Autowired ShopTagTbRepository shopTagTbRepository;
    @Autowired ShopTbRepository shopTbRepository;
    @Autowired UserTbRepository userTbRepository;
    @Autowired FavoriteTbRepository favoriteTbRepository;

    @Test @Transactional
    void 문제5() {
      Optional<ShopTb> opt = shopTbRepository.findById(64);
      ShopTb shopTb = opt.get();
      List<FavoriteTb> list = shopTb.getFavoriteTbList();
      for(FavoriteTb ft : list) {
        UserTb userTb = ft.getUserTb();
        String userName = userTb.getUserName();
        String email = userTb.getEmail();
        System.out.printf("%s %s\n", userName, email);
      }
    }
  
      @Test @Transactional
  void 문제4() {
    UserTb userTb = userTbRepository.findByUserName("한구름");
    List<FavoriteTb> list = userTb.getFavoriteTbList();
    for(FavoriteTb ft : list) {
      ShopTb shopTb = ft.getShopTb();
      String shopName = shopTb.getShopName();
      String shopDesc = shopTb.getShopDesc();
      System.out.printf("%s %s\n", shopName, shopDesc);
    }
  }

    @Test @Transactional
    void 문제3(){
      ShopTb shopTb = shopTbRepository.findByShopName("거북선횟집");
      List<ShopTagTb> list = shopTb.getShopTagTbList();
      for(ShopTagTb stt : list) {
        String tagName = stt.getTagTb().getTagName();
        System.out.println(tagName);
      }
    }  
    @Test @Transactional
  void 문제2() {
    Direction direction = Direction.DESC;
    Sort sort = Sort.by(direction, "hitCnt");
    Pageable pageable = PageRequest.of(0, 1, sort);
    Page<TagTb> p = tagTbRepository.findAll(pageable);
    TagTb tagTb = p.getContent().get(0);
    List<ShopTagTb> list = tagTb.getShopTagTbList();
    int size = list.size();
    System.out.println(size);
  }

    @Test
    void 문제1(){
        Direction direction = Direction.DESC;
        Sort sort = Sort.by(direction, "hitCnt");
        Pageable pageable = PageRequest.of(0, 2, sort);
        Page<TagTb> p = tagTbRepository.findAll(pageable);
        List<TagTb> list = p.getContent();
        for(TagTb t : list){
            System.out.println(t.getTagName());
        }
        
    }
}
// Order name = Order.desc("name");
// // Sort sort = Sort.by(sido, name);
// Order fadesc = Order.desc("hitcnt");
// Sort sort = Sort.by(fadesc);
// TagTb fa = tagTbRepsitory.findAll();     