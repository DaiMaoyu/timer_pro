package work.timer.serivce.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import work.timer.dao.mapper.TestMapper;
import work.timer.serivce.api.TestService;
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public int count() {
        return testMapper.count();
    }
}
