package org.conan.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class BoardService {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper= mapper;
    private BoardMapper;
}
