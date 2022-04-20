package com.projectmanager.service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;
import java.util.stream.Stream;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.projectmanager.entity.Admin;
//import com.projectmanager.entity.Documents;
import com.projectmanager.entity.FileDB;
import com.projectmanager.entity.Leaves;
import com.projectmanager.entity.Profile;
import com.projectmanager.entity.Projects;
import com.projectmanager.entity.SystemUser;
import com.projectmanager.entity.Task;
import com.projectmanager.repository.AdminRepository;
import com.projectmanager.repository.DocumentRepository;
import com.projectmanager.repository.FileDBRepository;
import com.projectmanager.repository.LeaveRepository;
import com.projectmanager.repository.ProfileRepository;
import com.projectmanager.repository.ProjectRepository;
import com.projectmanager.repository.Repository;
import com.projectmanager.repository.TaskRepository;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	private Repository repository;

	@Autowired
	private LeaveRepository leaveRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public SystemUser saveUser(SystemUser user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public SystemUser fetchUserByEmailId(String emailId) {
		return repository.findByEmailId(emailId);
	}

	@Override
	public SystemUser fetchUserByEmailIdAndPassword(String emailId, String password) {
		return repository.findByEmailIdAndPassword(emailId, password);
	}

	// to add project
	@Override
	public Projects saveAll(Projects projects) {

		return projectRepository.save(projects);

	}

	@Override
	public List<Projects> findAll() {
		List<Projects> projectList = new ArrayList<>();
		projectRepository.findAll().forEach(projectList::add);
		return projectList;

	}

	@Override
	public Projects getProject(int pId) {
		return projectRepository.findBypId(pId);
	}

	@Override
	public Leaves saveLeave(Leaves leaves) {
		return leaveRepository.save(leaves);

	}

	@Override
	public Profile saveProfile(Profile profile) {
		Profile profile2 = profileRepository.save(profile);
		return profile2;
	}

	@Override
	public Profile getProfile(String emailId) {

		Profile profile = profileRepository.findByEmailId(emailId);
		if (profile != null) {
			return profile;
		} else {
			return null;
		}
	}

	@Override
	public List<Leaves> getLeavesData() {
		List<Leaves> leaves = new ArrayList<>();
		leaveRepository.findAll().forEach(leaves::add);
		return leaves;
	}

	// update leave after decline by project managee
	@Override
	public Leaves update(Leaves leaves, int id) {
		Leaves olddata = null;
		Optional<Leaves> optionaluser = leaveRepository.findById(id);
		if (optionaluser.isPresent()) {
			olddata = optionaluser.get();
			System.out.println(olddata);
			// olddata.setDescription(leaves.getDescription());
			olddata.setReason(leaves.getReason());
			olddata.setStatus(leaves.getStatus());
			leaveRepository.save(olddata);
		} else {
			return new Leaves();
		}
		return olddata;
	}

	@Override
	public Leaves updateStatus(Leaves status, int id) {
		Leaves olddata = null;
		Optional<Leaves> optionaluser = leaveRepository.findById(id);
		if (optionaluser.isPresent()) {
			olddata = optionaluser.get();
			System.out.println(olddata);
			olddata.setStatus(status.getStatus());
			olddata.setReason(olddata.getReason());
			leaveRepository.save(olddata);
		} else {
			return new Leaves();
		}
		return olddata;
	}

	@Override
	public List<Profile> getProjects(int id) {
		List<Profile> profile = new ArrayList<>();
		// profile=profileRepository.findById(id);
		// findAll(id).
		List<Profile> optionalData = profileRepository.findByCurrentProjectId(id);
//		if(!optionalData.isEmpty())
//		{
//			profile.add(optionalData.get(id));
//		}
		return optionalData;
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Optional<Profile> getProfileData(int id) {
		Optional<Profile> profile = profileRepository.findByuserid(id);
		if (profile.isPresent()) {
			profile.get();
		}
		return profile;
	}

	@Override
	public List<Profile> getAllProfileData() {
		List<Profile> profiledata = new ArrayList<>();
		profileRepository.findAll().forEach(profiledata::add);
		return profiledata;
	}

	private JavaMailSender javaMailSender;

	@Autowired
	public void EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendMail(String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		javaMailSender.send(message);
	}

	@Override
	public List<Task> getTasksData() {
		List<Task> taskData = new ArrayList<>();
		taskRepository.findAll().forEach(taskData::add);
		return taskData;
	}


	@Override
	public List<Task> getAllTasks(int id) {
		// List<Task> Task = new ArrayList<>();
		List<Task> taskData = new ArrayList<>();
		taskRepository.findAllByUserid(id).forEach(taskData::add);
		return taskData;
	}

	@Override
	public Task updateStatus(int taskId, Task status) {
		Task oldstatus = null;
		Optional<Task> taskdata = taskRepository.findById(taskId);
		if (taskdata.isPresent()) {
			oldstatus = taskdata.get();
			oldstatus.setTaskStatus(status.getTaskStatus());
			oldstatus.setCompletionDate(status.getCompletionDate());
			taskRepository.save(oldstatus);
		} else {
			return new Task();
		}
		return oldstatus;
	}

	@Override
	public void sendMailByUser(String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		javaMailSender.send(message);

	}


	// apply for new project
	public Profile applyForNewProject(Profile profile, int pId) {
		Profile olddata = null;
		Optional<Profile> optionaluser = profileRepository.findByuserid(pId);
		if (optionaluser.isPresent()) {
			olddata = optionaluser.get();
			System.out.println(olddata);
			// olddata.setDescription(leaves.getDescription());
			// olddata.setReason(leaves.getReason());
			olddata.setNewProject(profile.getNewProject());
			olddata.setNewProjectId(profile.getNewProjectId());
			olddata.setProjectChangeId(profile.getProjectChangeId());
			profileRepository.save(olddata);
		} else {
			return new Profile();

		}
		return olddata;
	}

	// to get profiles who wants to change project change internally
	public List<Profile> getProfilesByProjectChangeId(int id) {
		return profileRepository.findByProjectChangeId(id);
	}

	// change the project by owner of employee
	@Override
	public Profile changeTheProjectInternal(Profile profile, int userId) {
		Profile olddata = null;
		Optional<Profile> optionaluser = profileRepository.findByuserid(userId);
		if (optionaluser.isPresent()) {
			olddata = optionaluser.get();
			olddata.setCurrentProject(olddata.getNewProject());
			olddata.setCurrentProjectId(olddata.getNewProjectId());
			olddata.setNewProject(null);
			olddata.setNewProjectId(0);
			olddata.setProjectChangeId(0);
			System.out.println(olddata.getNewProject() + "" + olddata.getNewProjectId());
			profileRepository.save(olddata);
		} else {
			return new Profile();
		}
		return olddata;
	}

	public void sendMailtoReset(String email, String subject, String body) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		// mailMessage.setFrom(frommail);
		mailMessage.setTo(email);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		javaMailSender.send(mailMessage);

		System.out.println("Email Sent Successfully!!");
		// return "Mail sent sucessfully!!!! check your email";
	}


		@Override
	public SystemUser changeIdentificationId(int id) {

		SystemUser oldId = null;
		Optional<SystemUser> user = repository.findById(id);
		if (user.isPresent()) {
			oldId = user.get();
			oldId.setNewProfileCheckId(1);
			repository.save(oldId);
		} else {
			return null;
		}
		return oldId;
	}

	@Override
	public Admin fetchAdminByEmailId(String email) {
		return this.adminRepository.findByEmailId(email);
	}

	@Override
	public Admin fetchAdminByEmailIdAndPassword(String email, String password) {
		return this.adminRepository.findByEmailIdAndPassword(email, password);
	}

	// for generate otp
	@Override
	public SystemUser forget(String email) {
		SystemUser olddata = null;
		olddata = repository.findByEmailId(email);
		int number = randomNo();
		olddata.setOtp(number);
		return olddata;
	}

	// genarate random no
	public int randomNo() {
		int min = 100000;
		int max = 999999;
		return (int) (Math.random() * (max - min + 1) + min);
	}

	// changePassword
	@Override
	public SystemUser changePassword(String emailId, SystemUser user) {

		SystemUser oldstatus = null;
		SystemUser user1 = repository.findByEmailId(emailId);
		Optional<SystemUser> data = repository.findByuserid(user1.getUserid());
		if (data.isPresent()) {
			oldstatus = data.get();
			oldstatus.setPassword(user.getPassword());
			oldstatus.setCpassword(user.getPassword());
			repository.save(oldstatus);
		} else {
			return new SystemUser();
		}
		return oldstatus;

	}

	@Autowired
	FileDBRepository fileDBRepository;

	public FileDB store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
		return fileDBRepository.save(FileDB);
	}

	public FileDB getFile(String id) {
		return fileDBRepository.findById(id).get();
	}

	public Stream<FileDB> getAllFiles() {
	    return fileDBRepository.findAll().stream();
	  }

	
	
	// =employeeList>
	@Override
	public Optional<Profile> getProfileForProjectChangeByManager(int userId) {
		return profileRepository.findByuserid(userId);
	}

	// =wmployeeList>
	// apply for new project
		public Profile applyNewProjectIn(Profile profile, int pId) {
			Profile olddata = null;
			Optional<Profile> optionaluser = profileRepository.findByuserid(pId);
			System.out.println(optionaluser.toString());
			if (optionaluser.isPresent()) {
				olddata = optionaluser.get();
				olddata.setCurrentProject(profile.getCurrentProject());
				olddata.setCurrentProjectId(profile.getCurrentProjectId());
				profileRepository.save(olddata);
			} else {
				return new Profile();

			}
			return olddata;
		}


}
