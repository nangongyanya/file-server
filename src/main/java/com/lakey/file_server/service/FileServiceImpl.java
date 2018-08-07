package com.lakey.file_server.service;

import com.lakey.file_server.dao.FileDao;
import com.lakey.file_server.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * File 服务接口
 *
 * @since 1.0.0 2018 年 8 月 6 日
 * @author Rimon
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    public FileDao fileDao;

    /**
     * 保存文件
     *
     * @param file
     * @return
     */
    @Override
    public File saveFile(File file) {
        return fileDao.save(file);
    }

    @Override
    public void removeFile(String id) {
        fileDao.deleteById(id);
    }

    /**
     * 根据id获取文件
     *
     * @param id
     * @return
     */
    @Override
    public Optional<File> getFileById(String id) {
        return fileDao.findById(id);
    }

    /**
     * 分页查询，按上传时间降序
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<File> listFilesByPage(int pageIndex, int pageSize) {
        Page<File> page = null;
        List<File> list = null;

        Sort sort = new Sort(Direction.DESC,"uploadDate");
        Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);

        page = fileDao.findAll(pageable);
        list = page.getContent();
        return list;
    }
}
