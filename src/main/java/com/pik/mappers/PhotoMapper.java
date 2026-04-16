package com.pik.mappers;

import com.pik.database.entities.Photo;
import com.pik.dtos.PhotoDTO;
import com.pik.mappers.core.GenericMapper;
import com.pik.services.PostService;

public class PhotoMapper implements GenericMapper<Photo, PhotoDTO> {
    PostService postService;

    PhotoMapper(PostService postService) {
        this.postService = postService;
    }

    public PhotoDTO toDto(Photo entity) {
        PhotoDTO dto = new PhotoDTO();
        dto.setDescription(entity.getDescription());
        dto.setId(entity.getId());
        dto.setLocalistion(entity.getLocalization());
        dto.setPostId(entity.getPost().getId());
        return dto;
    }

    public Photo toEntity(PhotoDTO dto) {
        Photo photo = new Photo();

        photo.setId(dto.getId());
        photo.setDescription(dto.getDescription());
        photo.setPost(postService.findById(dto.getId()));

        return photo;
    }
}
