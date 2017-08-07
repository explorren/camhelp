package com.camhelp.controller;

import com.camhelp.VO.ResultVO;
import com.camhelp.dataobject.User;
import com.camhelp.service.UserService;
import com.camhelp.utils.ResultVoUtils;
import com.camhelp.utils.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jupiter on 2017/7/23.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("hello")
    public  String Hello(){
        return "hello!";

    }

    @RequestMapping("/find/{id}")
    public ResultVO<User> FindOne(@PathVariable("id") Integer id){

        return ResultVoUtils.success(userService.findOne(id));
    }

    @RequestMapping("/list")
    public ResultVO<List<User>> userList(){
        return ResultVoUtils.success(userService.findAllUser());
    }


    @RequestMapping("/login")
    public ResultVO  Login(@RequestParam("account") String account,@RequestParam("password") String password) throws Exception{

        User user=userService.findUserByAccount(account);
        if(account==null){

            return ResultVoUtils.error(-1,"账户为空");
        }else if(!user.getPassword().equals(password)){
            return ResultVoUtils.error(-1,"密码不正确");

        }else if (user.getPassword().equals(password)){
            Map<String, String> map = new HashMap<>();
            map.put("userid",user.getUserID().toString());
             return ResultVoUtils.success(map);
        }else {
            return ResultVoUtils.error(-1,"未知错误");
        }

    }

    @RequestMapping("register")
    public ResultVO Register(@Valid User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
              return ResultVoUtils.error(-1,"参数不正确");
        }
        if(userService.findUserByAccount(user.getAccount())!=null){
            return ResultVoUtils.error(-1,"账号已存在");
        }
        userService.SaveUser(user);

        Map<String, String> map = new HashMap<>();
        map.put("userid",userService.findUserByAccount(user.getAccount()).getUserID().toString());

        return ResultVoUtils.success(map);
    }

    //完善个人信息

    @RequestMapping("update/password")
    public ResultVO updatePassword(@RequestParam("id") Integer id,@RequestParam("password") String password)
    {
        userService.updatePasswordById(password,id);

        return ResultVoUtils.success();
    }

    @RequestMapping("update/avatar")
    public ResultVO updateAvatar(@RequestParam("id") Integer id,@RequestParam("avatar") List<MultipartFile> files){

        List<String> list=null;
        try{
            list= UploadFileUtils.uploadFile(files,"user");
        }catch (Exception e){
            ResultVoUtils.error(-1,"上传图片出错");
        }

       try {
           userService.updateAvatarById(list.get(0),id);
       }catch (Exception e){
            ResultVoUtils.error(-1,"更新出错");
       }


        Map<String,String> map=new HashMap<>();

        map.put("avatar",userService.findOne(id).getAvatar());
        return  ResultVoUtils.success(map);
    }

    @RequestMapping("update/nickname")
    public ResultVO updateNickename(@RequestParam("id") Integer id,@RequestParam("nickname") String nickname)
    {
        userService.updateNicknameById(nickname,id);


        Map<String,String> map=new HashMap<>();

        map.put("nickname",userService.findOne(id).getNickname());

        return ResultVoUtils.success(map);
    }

    @RequestMapping("update/address")
    public ResultVO updateAddress(@RequestParam("id") Integer id,@RequestParam("address") String address)
    {
        userService.updateAddressById(address,id);

        Map<String,String> map=new HashMap<>();

        map.put("address",userService.findOne(id).getAddress());

        return ResultVoUtils.success(map);
    }
    @RequestMapping("update/birthday")
    public ResultVO updateBirthday(@RequestParam("id") Integer id,@RequestParam("birthday") String birthday)
    {
        userService.updateBirthdayById(birthday,id);

        Map<String,String> map=new HashMap<>();

        map.put("birthday",userService.findOne(id).getBirthday());

        return ResultVoUtils.success(map);
    }
    @RequestMapping("update/email")
    public ResultVO updateEmail(@RequestParam("id") Integer id,@RequestParam("email") String email)
    {
        userService.updateEmailById(email,id);

        Map<String,String> map=new HashMap<>();

        map.put("email",userService.findOne(id).getEmail());

        return ResultVoUtils.success(map);
    }
    @RequestMapping("update/sex")
    public ResultVO updateSex(@RequestParam("id") Integer id,@RequestParam("sex") String sex)
    {
        userService.updateSexById(sex,id);

        Map<String,String> map=new HashMap<>();

        map.put("sex",userService.findOne(id).getSex().toString());

        return ResultVoUtils.success(map);
    }
    @RequestMapping("update/intro")
    public ResultVO updateIntro(@RequestParam("id") Integer id,@RequestParam("intro") String intro)
    {
        userService.updateIntroById(intro,id);

        Map<String,String> map=new HashMap<>();

        map.put("intro",userService.findOne(id).getIntro());

        return ResultVoUtils.success(map);
    }
    @RequestMapping("update/telephone")
    public ResultVO updateTelephone(@RequestParam("id") Integer id,@RequestParam("telephone") String telephone)
    {
        userService.updatePasswordById(telephone,id);

        Map<String,String> map=new HashMap<>();

        map.put("telephone",userService.findOne(id).getNickname());

        return ResultVoUtils.success(map);
    }
}
