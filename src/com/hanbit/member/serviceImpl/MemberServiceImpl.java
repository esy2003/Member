package com.hanbit.member.serviceImpl;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;
import com.sun.swing.internal.plaf.metal.resources.metal;

import sun.security.util.Length;

public class MemberServiceImpl implements MemberService{
   int count;
   MemberBean member;
   MemberBean[]list;
   //생성자 처리
   //public 클래스명(자료형 인자-콘드롤러에서 데려온 총회원 수)
   //count member list 초기화!!
   //거대한 for문이다.
   //초기화
   public MemberServiceImpl() {
      count = 0;
      member= new MemberBean();
      list = new MemberBean[count];
   }
   @Override
   public void addMember(MemberBean member){
      if(count==list.length){
      MemberBean[] temp =new MemberBean[count+1];
      System.arraycopy(list,0, temp, 0, count);
      list=temp;
      }
      list[count++]=member;
   //list[count]=member;
   //for(int i=0;i<(count+1);i++){
   //System.out.println(list[i].toString());
      }
   //범위(for문)
   //   count++;
      
   @Override
   public MemberBean[] getMembers() {
      return  list;
   }
   
   @Override
   public int countMembers() {
   return count;
   }
   
   @Override
   public MemberBean findById (String id) {
   member=new MemberBean();
   //위에서 instance 변수 member를 쓴적이 없어서 지워도 된다.
   for(int i=0;i<list.length;i++){
   if(id.equals(list[i].getUserId())){
   member=list[i];
   }
   }
   return member ;
   }
   @Override
   public MemberBean[] findByName(String name){
   //답은 MemberBean타입의 배열
   int x=0;
      for(int i=0;i<list.length;i++){
         if((name).equals(list[i].getName())){
         x++;
      }
   }
   MemberBean[] members=new MemberBean[count];
   int j=0;
   for(int i=0;i<list.length;i++){
      if((name).equals(list[i].getName())){
         members[j]=list[i];
         j++;
      }
      if(x==j){
         break;
      }
      }
   return members;
   }
   @Override
   public void updatePass(MemberBean bean) {
      findById(bean.getUserId()).setUserPw(bean.getUserPw());
      /*for(int i=0;i<list.length;i++){
      if(member.getId().equals(list[i].getId())){
      list[i].setPassword(member.getPassword());*/
   }
   @Override
   public void delete(String id) {
      for(int i=0;i<count;i++){
         if(id.equals(list[i].getUserId())){
   //         list[i]=null;
   //         list[i]=list[i+1];
            list[i]=list[count-1];
            list[count-1]=null;
            count--;         
         }   
      }
   }
}   