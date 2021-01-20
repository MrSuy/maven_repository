package cn.jiyun.controllrt;


import cn.jiyun.pojo.Address;
import cn.jiyun.pojo.Student;
import cn.jiyun.service.AddServuce;
import cn.jiyun.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StuController{
    @Autowired
    private StuService stuService;
    @Autowired
    private AddServuce addServuce;

     @RequestMapping("/findPage")
        public String findPage(Student student, Integer pageNums, Model model) {
//        设置当前页
         Integer pageNum=0;
         if (pageNums!=null && pageNums>0){
            pageNum=pageNums;
         }
         /*获取姓名，生日，地址*/
         String name = student.getName();
         Date birthday = student.getBirthday();
         String addres = student.getAddres();
         System.out.println(birthday);
         /*分页查询*/
         Pageable pageable = PageRequest.of(pageNum, 2);
         Page<Student> page= stuService.findStuByPage(name,birthday,addres,pageable);
         List<Student> list = page.getContent();
         int totalPages = page.getTotalPages();

        /*发送到页面*/
         model.addAttribute("addres",addres);
         model.addAttribute("name",name);
         model.addAttribute("birthday",birthday);
         model.addAttribute("page",page);
         model.addAttribute("pageNum",pageNum);
         model.addAttribute("total",totalPages);
         model.addAttribute("list",list);
         return "show";
     }

     /*去删除页面*/
     @RequestMapping("/toDel")
    public String toDel(Long id){
         stuService.toDel(id);
         return "redirect:/student/findPage";
     }

     /*区添加页面*/
     @RequestMapping("/toAdd")
    public String toAdd(Model model){
         Integer aid=0;
        List<Address> list=stuService.findByAid(aid);
         model.addAttribute("list",list);

         model.addAttribute("dad",new Date());
         return "add";
     }

     /*三级联动*/
     @RequestMapping("/erji")
     @ResponseBody
    public List<Address> erji(Integer aid){
         List<Address> byAid = stuService.findByAid(aid);
         return byAid;
     }

     /*添加*/
     @RequestMapping("AddCon")
     @ResponseBody
     public String AddCon(@RequestBody Student student){
         /*获取省市区id*/
         Long shengid = student.getShengid();
         Long shiid = student.getShiid();
         Long xianid=student.getXianid();

         /*根据id获取地址*/
        Address ad=addServuce.findBySid(shengid);
         Address bySid = addServuce.findBySid(shiid);
         Address xian = addServuce.findBySid(xianid);

         /*添加进student表中*/
         student.setSheng(ad.getAname());
        student.setShi(bySid.getAname());
        student.setXian(xian.getAname());
        student.setAddres(ad.getAname()+"-"+bySid.getAname()+"-"+xian.getAname());
        /*添加*/
         try {
             stuService.add(student);
             return "1";
         } catch (Exception e) {
             e.printStackTrace();
             return "2";
         }

     }

     /*区修改页面*/
    @RequestMapping("toUpda")
    public String toUpda(Long id,Model model){
        /*更具id查询学生信息*/
        Student student=stuService.findByid(id);
         Integer aid=0;
         /*查询地址*/
         List<Address> list=stuService.findByAid(aid);
        model.addAttribute("dad",new Date());
         model.addAttribute("list",list);
        model.addAttribute("student",student);
        return "update";
     }


     /*修改*/
     @RequestMapping("/UpdaCon")
     @ResponseBody
    public String UpdaCon(@RequestBody Student student){
         /*获取省市区id*/
         Long shengid = student.getShengid();
         Long shiid = student.getShiid();
         Long xianid=student.getXianid();

         /*根据id获取地址*/
         Address ad=addServuce.findBySid(shengid);
         Address bySid = addServuce.findBySid(shiid);
         Address xian = addServuce.findBySid(xianid);

         /*添加进student表中*/
         student.setSheng(ad.getAname());
         student.setShi(bySid.getAname());
         student.setXian(xian.getAname());
         student.setAddres(ad.getAname()+"-"+bySid.getAname()+"-"+xian.getAname());

         /*修改*/
         try {
             stuService.update(student);
             return "1";
         } catch (Exception e) {
             e.printStackTrace();
             return "2";
         }
     }


     /*去统计页面*/
    @RequestMapping("Tongji")
    public String Tongji(Model model){
        /*男*/
       String n="1";
       Integer nan=stuService.findBySex(n);
       /*女*/
       String s="2";
       Integer bySex = stuService.findBySex(s);
       model.addAttribute("n",nan);
       model.addAttribute("s",bySex);
        return "tongji";
    }
//    退出页面
    @RequestMapping("tui")
    public String tui(){
        return "redirect:/student/findPage";
    }

}
