package legostore.framework.web;

import org.modelmapper.ModelMapper;

import java.util.HashMap;

/**
 * Created by chanwook on 2015. 2. 25..
 */
public class EmberModel extends HashMap<String, Object> {
    public <T> T get(String key, Class<T> type) {
        if (!super.containsKey(key)) {
            throw new RuntimeException("key에 해당하는 엠버 데이터 모델이 없습니다.");
        }
        Object object = super.get(key);

        ModelMapper mapper = new ModelMapper();
        T target = mapper.map(object, type);
        return target;
    }
}
