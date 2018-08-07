package com.lakey.file_server.dao;

import com.lakey.file_server.domain.File;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * File 存储库
 *
 * @since 1.0.0 2018 年 8 月 6 日
 * @author Rimon
 */
public interface FileDao extends MongoRepository<File, String> {
}
