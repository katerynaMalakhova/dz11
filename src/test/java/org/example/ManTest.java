package org.example;

import com.rd.people.Man;
import com.rd.people.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ManTest {
    private Woman woman;
    private Man man;
    @BeforeSuite(groups = {"smoke"})
    public void creatingPeople(){
        woman = new Woman("FirstName", "LastName", 30);
        man = new Man("ManFirstName", "ManLastName", 40);
    }

    @Test(groups = {"smoke"})
    public void getFirstNameTest(){
        Assert.assertEquals(man.getFirstName(), "ManFirstName", "First name is wrong\n");
    }
    @Test(groups = "smoke")
    public void setFirstNameTest(){
        man.setFirstName("changedFirstName");
        Assert.assertEquals(man.getFirstName(), "changedFirstName", "First name was not reset\n");
    }
    @Test(groups = "smoke")
    public void getLastNameTest(){
        Assert.assertEquals(man.getLastName(), "ManLastName", "Last name is wrong\n");
    }
    @Test(groups = "smoke")
    public void setLastNameTest(){
        man.setLastName("changedLastName");
        Assert.assertEquals(man.getLastName(), "changedLastName", "Last name was not reset\n");
    }
    @Test(groups = "smoke")
    public void getAgeTest(){
        Assert.assertEquals(man.getAge(), 40,"Age is wrong\n");;
    }
    @Test(groups = "smoke")
    public void setAgeTest(){
        man.setAge(31);
        Assert.assertEquals(man.getAge(), 31,"Age was not reset\n");;
    }
    @Test(groups = "smoke")
    public void getSexTest(){
        Assert.assertEquals(man.getSex(), "male","Sex is wrong\n");;
    }
    @Test(groups = "smoke")
    public void setSexTest(){
        man.setSex("female");
        Assert.assertEquals(man.getSex(), "female", "Sex was not reset\n");;
    }
    @Test
    public void isNotRetiredTest(){
        man.setAge(64);
        Assert.assertEquals(man.isRetired(man), false,"Retirement indicated wrong (the man is not retired)\n");;
    }
    @Test
    public void isRetiredTest(){
        man.setAge(65);
        Assert.assertEquals(man.isRetired(man), true,"Retirement indicated wrong (the man is retired)\n");;
    }
    @Test(groups = "smoke")
    public void getPartnerTest(){
        Assert.assertEquals(man.getPartner(), null, "Wrong! No partner is registered\n");
    }
    @Test(groups = "smoke")
    public void setPartnerTest(){
        man.setPartner(woman);
        Assert.assertEquals(man.getPartner(), woman, "Partner is set correctly\n");
        man.setPartner(null);
    }

    @Test
    public void registerPartnershipTest() {
        man.registerPartnership(woman);
        Assert.assertEquals(man.getPartner(), woman, "Registration of partnership failed. Partner is not set\n");
     }
    @Test
    public void deregisterPartnershipTest() {
        man.deregisterPartnership();
        Assert.assertEquals(man.getPartner(), null, "Deregistration of partnership failed. Partner is still set\n");
    }

}
