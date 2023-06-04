package org.example;

import com.rd.people.Woman;
import com.rd.people.Man;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WomanTest {

private Woman woman;
private Man man;
    @BeforeSuite(groups = {"smoke"})
    public void creatingPeople(){
    woman = new Woman("FirstName", "LastName", 30);
    man = new Man("ManFirstName", "ManLastName", 40);
}

    @Test(groups = "smoke")
    public void getFirstNameTest(){
        Assert.assertEquals(woman.getFirstName(), "FirstName", "First name is wrong\n");
    }
    @Test(groups = "smoke")
    public void setFirstNameTest(){
        woman.setFirstName("changedFirstName");
        Assert.assertEquals(woman.getFirstName(), "changedFirstName", "First name was not reset\n");
    }
    @Test(groups = "smoke")
    public void getLastNameTest(){
        Assert.assertEquals(woman.getLastName(), "LastName", "Last name is wrong\n");
    }
    @Test
    public void setLastNameTest(){
        woman.setLastName("changedLastName");
        Assert.assertEquals(woman.getLastName(), "changedLastName", "Last name was not reset\n");
    }
    @Test(groups = "smoke")
    public void getMaidenNameTest(){
        Assert.assertEquals(woman.getMaidenName(), "LastName", "Maiden name is wrong\n");
    }

    @Test(groups = "smoke")
    public void getAgeTest(){
        Assert.assertEquals(woman.getAge(), 30,"Age is wrong\n");;
    }
    @Test(groups = "smoke")
    public void setAgeTest(){
        woman.setAge(31);
        Assert.assertEquals(woman.getAge(), 31,"Age was not reset\n");;
    }
    @Test(groups = "smoke")
    public void getSexTest(){
        Assert.assertEquals(woman.getSex(), "female","Sex is wrong\n");;
    }
    @Test(groups = "smoke")
    public void setSexTest(){
        woman.setSex("male");
        Assert.assertEquals(woman.getSex(), "male", "Sex was not reset\n");;
    }
    @Test
    public void isNotRetiredTest(){
        woman.setAge(59);
        Assert.assertEquals(woman.isRetired(woman), false,"Retirement indicated wrong (the woman is not retired)\n");;
    }
    @Test
    public void isRetiredTest(){
        woman.setAge(60);
        Assert.assertEquals(woman.isRetired(woman), true,"Retirement indicated wrong (the woman is retired)\n");;
    }
    @Test(groups = "smoke")
    public void getPartnerTest(){
        Assert.assertEquals(woman.getPartner(), null, "Wrong! No partner is registered\n");
    }
    @Test(groups = "smoke")
    public void setPartnerTest(){
        woman.setPartner(man);
        Assert.assertEquals(woman.getPartner(), man, "Partner is set correctly\n");
        woman.setPartner(null);
    }

    @Test
    public void registerPartnershipTest() {
        woman.registerPartnership(man);
        Assert.assertEquals(woman.getPartner(), man, "Registration of partnership failed. Partner is not set\n");
        Assert.assertEquals(woman.getLastName(), man.getLastName(), "Registration of partnership failed. LastName was not changed\n");
    }
    @Test
    public void deregisterPartnershipTest() {
        woman.deregisterPartnership();
        Assert.assertEquals(woman.getPartner(), null, "Deregistration of partnership failed. Partner is still set\n");
        Assert.assertEquals(woman.getLastName(), woman.getMaidenName(), "Deregistration of partnership failed. LastName was not updated\n");
    }

}
