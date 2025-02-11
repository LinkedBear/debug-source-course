package com.linkedbear.debugsource.mapperaop.base;

import com.linkedbear.debugsource.mapperaop.aop.OperationLog;

public interface BaseMapper<T> {
    
    @OperationLog(content = "保存数据")
    int save(T t);
}
