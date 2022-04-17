package com.projectmanager.service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.projectmanager.entity.Documents;
import com.projectmanager.entity.Leaves;
import com.projectmanager.entity.Profile;
import com.projectmanager.entity.Projects;
import com.projectmanager.entity.SystemUser;
import com.projectmanager.entity.Task;
import com.projectmanager.repository.DocumentRepository;
import com.projectmanager.repository.LeaveRepository;
import com.projectmanager.repository.ProfileRepository;
import com.projectmanager.repository.ProjectRepository;
import com.projectmanager.repository.Repository;
import com.projectmanager.repository.TaskRepository;

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

//	@Override
//	public List<LeavesDetails> findAll() {
//		List<LeavesDetails> leavesList = new ArrayList<>();
//		leaveRepo.findAll().forEach(leavesList::add);
//		return leavesList;
//	}

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
		Optional<Profile> profile = profileRepository.findById(id);
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

	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public Documents store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Documents filedata = new Documents(fileName, file.getContentType(), file.getBytes());
		return documentRepository.save(filedata);
	}

	@Override
	public Documents getFile(int id) {
		return documentRepository.findById(id).get();
	}

	@Override
	public Stream<Documents> getAllFiles() {
		return documentRepository.findAll().stream();
	}

	@Override
	public List<Documents> getDocumentData() {
		List<Documents> docsData = new ArrayList<>();
		documentRepository.findAll().forEach(docsData::add);
		return docsData;
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

//	 @Value("${files.path}")
//	    private String filesPath;
//
//	    public Resource download(String filename) {
//	        try {
//	            Path file = Paths.get(filesPath)
//	                             .resolve(filename);
//	            Resource resource = new UrlResource(file.toUri());
//
//	            if (resource.exists() || resource.isReadable()) {
//	                return resource;
//	            } else {
//	                throw new RuntimeException("Could not read the file!");
//	            }
//	        } catch (MalformedURLException e) {
//	            throw new RuntimeException("Error: " + e.getMessage());
//	        }
//	    }
//
//	    public List<FileData> list() {
//	        try {
//	            Path root = Paths.get(filesPath);
//
//	            if (Files.exists(root)) {
//	                return Files.walk(root, 1)
//	                            .filter(path -> !path.equals(root))
//	                            .filter(path -> path.toFile()
//	                                                .isFile())
//	                            .collect(Collectors.toList())
//	                            .stream()
//	                            .map(this::pathToFileData)
//	                            .collect(Collectors.toList());
//	            }
//
//	            return Collections.emptyList();
//	        } catch (IOException e) {
//	            throw new RuntimeException("Could not list the files!");
//	        }
//	    }
//
//	    private FileData pathToFileData(Path path) {
//	        FileData fileData = new FileData();
//	        String filename = path.getFileName()
//	                              .toString();
//	        fileData.setFilename(filename);
//
//	        try {
//	            fileData.setContentType(Files.probeContentType(path));
//	            fileData.setSize(Files.size(path));
//	        } catch (IOException e) {
//	            throw new RuntimeException("Error: " + e.getMessage());
//	        }
//
//	        return fileData;
//	    }

}
