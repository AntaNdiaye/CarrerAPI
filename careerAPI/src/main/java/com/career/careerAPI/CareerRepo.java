package com.career.careerAPI;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CareerRepo implements CareerService{

    static List<Career> careerList = new ArrayList<>();

    static{
        Career softwareEngineer = new Career("Software Engineer", "Build App's,", 1000.00);
        careerList.add(softwareEngineer);
    }
    @Override
    public  void updateMethod(String oldJobTitle, Career upCareer){
        String newJobTitle = upCareer.getJobTitle();
        String newDescription = upCareer.getJobDescription();
        Double newSalary = upCareer.getSalary();

        for(Career career : getCareerList()){
            if(career.getJobTitle().equals(oldJobTitle)){
                career.setJobTitle(newJobTitle);
                career.setJobDescription(newDescription);
                career.setSalary(newSalary);
                return;
            }
        }

    }
    @Override
    public  List<Career> getCareerList() {
        return careerList;
    }
    @Override
    public  void addCareer(Career newCareer){
        careerList.add(newCareer);
    }
    @Override
    public  void deleteAllCareer(){
        careerList.clear();
    }

    @Override
    public Boolean deleteCareer(String delCareer) {
        for(Career career : getCareerList()) {
            if (career.getJobTitle().equals(delCareer)) {
                return careerList.remove(career);
            }
        }
        return null ;
    }

    @Override
    public Career searchCareer(String theCareer) {
        for(Career career : getCareerList()){
            if(career.getJobTitle().equals(theCareer)){
                return career;
            }
        }
        return null;
    }

}
