package com.lakey.file_server.service;

import com.lakey.file_server.domain.File;

import java.util.List;
import java.util.Optional;

/**
 * File 服务接口
 *
 * @since 1.0.0 2018 年 8 月 6 日
 * @author Rimon
 */
public interface FileService {

    /**
     * 保存文件
     *
     * @param file
     * @return
     */
    File saveFile(File file);

    /**
     * 删除文件
     * @param id
     * @return
     */
    void removeFile(String id);

    /**
     * 根据id获取文件
     *
     * @param id
     * @return
     */
    Optional<File> getFileById(String id);

    /**
     * 分页查询，按上传时间降序
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<File> listFilesByPage(int pageIndex, int pageSize);
}
