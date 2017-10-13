package com.springboot.mongo;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WIN on 2017/10/13.
 */
@RestController
@RequestMapping("/customer")
@Api("customer相关的API，用于测试mongodb")
public class CustomerController {

   /* @Autowired
    private CustomerRepository customerRepository;

    //复杂查询
//    @Autowired
//    private MongoTemplate mongoTemplate;

    @ApiOperation("add customer test")
    @RequestMapping(value = "/addCustomer",method = RequestMethod.GET)
    public Customer addCustomer(@RequestParam("firstname") String firstname,
                                 @RequestParam("secondname") String secondname) {
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setSecondname(secondname);
        return customerRepository.save(customer);
    }

    @ApiOperation("get all customers")
    @RequestMapping(value="/getCustomers",method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @ApiOperation("get customer by firstname")
    @RequestMapping(value="/getCustomerByFirstname",method = RequestMethod.GET)
    public Customer getCustomerByFirstname(@RequestParam("firstname") String firstname) {
        return customerRepository.findByFirstname(firstname);
    }

    @ApiOperation("get customers by secondname")
    @RequestMapping(value ="/getCustomersBySecondname")
    public List<Customer> getCustomersBySecondname(@RequestParam("secondname") String secondname) {
        return customerRepository.findBySecondname(secondname);
    }

    @ApiOperation("delete customer by cid")
    @RequestMapping(value="/deleteCustomerBycid", method = RequestMethod.GET)
    public boolean delCustomerBycid(@RequestParam("id") String id) {
        customerRepository.delete(id);
        return true;
    }*/

   /* @ApiOperation("复杂的customer查询")
    @RequestMapping(value = "/getCustomerByfirstnameOrsecondname",method = RequestMethod.GET)
    public List<Customer> getCustomers(@RequestParam("firstname") String firstname,
                                       @RequestParam(value="name",required = false) String name,
                                       @RequestParam(value="secondname",required = false) String secondname) {
        BasicDBList orList = new BasicDBList();
        if(null != secondname) {
            orList.add(new BasicDBObject("secondname", secondname));
        }
        if(null != name) {
            orList.add(new BasicDBObject("name", name));
        }
        BasicDBObject orDBObject = new BasicDBObject("$or", orList);
        BasicDBList andList = new BasicDBList();
        andList.add(new BasicDBObject("firstname", firstname));
        andList.add(orDBObject);
        BasicDBObject andDBObject = new BasicDBObject("$and", andList);
        //select * from customer where firstname = ? and (name = ? or secondname = ?)
        return mongoTemplate.find(new BasicQuery(andDBObject), Customer.class);
    }*/


 }
