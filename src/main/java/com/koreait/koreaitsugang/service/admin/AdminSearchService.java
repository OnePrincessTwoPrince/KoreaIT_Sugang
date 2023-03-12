package com.koreait.koreaitsugang.service.admin;

<<<<<<< HEAD
import com.koreait.koreaitsugang.entity.UserImage;
import com.koreait.koreaitsugang.entity.UserMst;
import com.koreait.koreaitsugang.exception.CustomValidationException;
import com.koreait.koreaitsugang.repository.admin.MajorRepository;
import com.koreait.koreaitsugang.web.dto.admin.*;
=======
import com.koreait.koreaitsugang.entity.SubjectMst;
import com.koreait.koreaitsugang.exception.CustomValidationException;
import com.koreait.koreaitsugang.repository.admin.SubjectRepository;
import com.koreait.koreaitsugang.web.dto.DeleteSubjectsReqDto;
import com.koreait.koreaitsugang.web.dto.SearchNumberListReqDto;
import com.koreait.koreaitsugang.web.dto.SearchReqDto;
import com.koreait.koreaitsugang.web.dto.SubjectReqDto;
>>>>>>> ft-05
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
=======
>>>>>>> ft-05
import java.util.*;

@Service
public class AdminSearchService {

    @Value("${file.path}")
    private String filePath;
    @Autowired
    private SubjectRepository subjectRepository;

    public List<SubjectMst> searchSugang(SearchReqDto searchReqDto) {
        searchReqDto.setIndex();
        return subjectRepository.searchSugang(searchReqDto);
    }

    public List<String> Categories(){
<<<<<<< HEAD
        List<String> category = majorRepository.majorCategory();
        System.out.println(category);
        return category;
    }

    public int UserTotalCounts(AdminSearchReqDto adminSearchReqDto){
        int usercount = majorRepository.getSearchUserTotalCount(adminSearchReqDto);
        System.out.println(usercount);
        return majorRepository.getSearchUserTotalCount(adminSearchReqDto);
    }

    public List<UserMst> getAdminSearchUser(AdminSearchReqDto adminSearchReqDto){
        adminSearchReqDto.setIndex();
        return majorRepository.getSearchUser(adminSearchReqDto);
    }

    public void removeUser(String username){
        majorRepository.deleteUser(username);
    }

    public void removeUsers(DeleteUserReqDto deleteUserReqDto){
        majorRepository.deleteUsers(deleteUserReqDto.getUsernames());
    }

    public void registerUserImage(String username, List<MultipartFile> files){
        if(files.size() < 1) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("files", "이미지를 선택하세요.");

            throw new CustomValidationException(errorMap);
        }

        List<UserImage> userImages = new ArrayList<UserImage>();

        files.forEach(file -> {
            String originFileName = file.getOriginalFilename();
            String extension = originFileName.substring(originFileName.lastIndexOf("."));
            String tempFileName = UUID.randomUUID().toString().replaceAll("-", "") + extension;

            Path uploadPath = Paths.get(filePath + "user/" + tempFileName);

            File f = new File(filePath + "user");
            if(!f.exists()) {
                f.mkdirs();
            }

            try {
                Files.write(uploadPath, file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            UserImage userImage = UserImage.builder()
                    .username(username)
                    .saveName(tempFileName)
                    .originName(originFileName)
                    .build();

            userImages.add(userImage);
        });

        majorRepository.registerUserImage(userImages);
    }

    public void dublicateUsername(String username){
        UserMst userMst = majorRepository.findUsername(username);
        if(userMst != null){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "이미 존재하는 학번(직번)입니다.");

            throw new CustomValidationException(errorMap);
        }
    }

    public void registerStudent(AddStudentReqDto addStudentReqDto){
        System.out.println("학생등록");
        majorRepository.saveStudent(addStudentReqDto);
        majorRepository.saveStudentMst(addStudentReqDto);
    }

    public void registerProfessor(AddProfessorReqDto addProfessorReqDto){
        System.out.println("교수등록");
        majorRepository.saveProfessor(addProfessorReqDto);
        majorRepository.saveProfessorMst(addProfessorReqDto);
    }

    public Map<String, Object> getUsernameAndImage(String username){
        Map<String, Object> result = new HashMap<>();
        result.put("username", majorRepository.findUsernameByUsername(username));
        result.put("userImage", majorRepository.findUserImageByUsername(username));
=======
        List<String> category = subjectRepository.majorCategory();
        return category;
    }

    public int getSubjectTotalCount(SearchNumberListReqDto searchNumberListReqDto) {
        return subjectRepository.getSubjectTotalCount(searchNumberListReqDto);
    }

    public void deleteSubject(DeleteSubjectsReqDto deleteSubjectsReqDto){
        subjectRepository.deleteBySubjectCode(deleteSubjectsReqDto.getSubjectCodes());
    }

    public void saveSubject(SubjectReqDto subjectReqDto){
        duplicateSubjectCode(subjectReqDto.getSubjectCode());
        subjectRepository.saveSubject(subjectReqDto);
    }

    public void modifySubject(SubjectReqDto subjectReqDto){
        subjectRepository.updateSubjectBySubjectCode(subjectReqDto);
    }

    public Map<String, Object> getSugang(int subjectCode){
        Map<String, Object> result = new HashMap<>();
        result.put("subjectMst", subjectRepository.findBySubjectCode(subjectCode));
>>>>>>> ft-05

        return result;
    }

<<<<<<< HEAD
    public void modifyStudent(UpdateStudentReqDto updateStudentReqDto){
        majorRepository.updateStudentByUsername(updateStudentReqDto);
        majorRepository.updateStudentmstByUseranme(updateStudentReqDto);
    }

    public void removeUserImage(String username){
        UserImage userImage = majorRepository.findUserImageByUsername(username);

        if(userImage == null){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", "존재하지 않는 이미지 ID입니다.");

            throw new CustomValidationException(errorMap);
        }

        if(majorRepository.deleteUserImage(username) > 0){
            File file = new File(filePath + "user/" + userImage.getSaveName());
            if(file.exists()){
                file.delete();
            }
        }
=======
    private void duplicateSubjectCode(int subjectCode) {
        SubjectMst subjectMst = subjectRepository.findBySubjectCode(subjectCode);
        if(subjectMst != null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("subjectCode", "이미 존재하는 과목 코드입니다.");

            throw new CustomValidationException(errorMap);
        }
>>>>>>> ft-05
    }
}
