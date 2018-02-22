package com.dfb.recommender.rest.dto;

import com.dfb.recommender.entities.Link;
import com.dfb.recommender.entities.Tag;
import com.dfb.recommender.entities.User;

import java.util.List;

/**
 * Created by Dante on 2/22/2018.
 */
public class UserDto implements BaseDto<User>{



    @Override
    public User toData() {
        return null;
    }

    @Override
    public void fromData(User data) {
    }
}
