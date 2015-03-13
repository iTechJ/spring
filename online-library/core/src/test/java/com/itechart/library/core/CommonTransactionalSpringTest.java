package com.itechart.library.core;


import org.junit.Ignore;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@Ignore
@ContextConfiguration("classpath:/ctx-test-*.xml")
public class CommonTransactionalSpringTest extends AbstractTransactionalJUnit4SpringContextTests {

    protected PageRequest buildPage(int pageNumber) {
        return new PageRequest(pageNumber, 10, new Sort(new Sort.Order(Sort.Direction.ASC, "id")));
    }
}
