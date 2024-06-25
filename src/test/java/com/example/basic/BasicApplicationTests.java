package com.example.basic;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.basic.entity.Major;
import com.example.basic.entity.Player;
import com.example.basic.entity.Team;
import com.example.basic.repository.MajorRepository;
import com.example.basic.repository.PlayerRepository;
import com.example.basic.repository.TeamRepository;
import com.example.basic.utill.Mailer;
import com.example.basic.utill.SMTPAuthenticator;

@SpringBootTest
class BasicApplicationTests {
	@Autowired
	Mailer mailer;
	@Test
	void 메일(){
		mailer.sendMail("ggoreb.kim@gamil.com", // 보낼 이메일
		 "제목 : 안녕", "내용 : 메일 보내기 테스트", new SMTPAuthenticator());
	}















	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	TeamRepository teamRepository;

	@Test @Transactional
	void TeamRepository조회Test() {
		Optional<Team> opt = teamRepository.findById(1);
		if(opt.isPresent()) {
			Team team = opt.get();
			System.out.println(team);
			// List<Player> players = team.getPlayers();
			// for(Player p : players) {
			// 	System.out.println(p.getPlayerName());
			// }
		}
	}

	@Test @Transactional
	void PlayerRepository조회Test() {
		Optional<Player> opt = playerRepository.findById(2);
		if(opt.isPresent()) {
			Player p = opt.get();
			System.out.println(p.getPlayerName());
			Team t = p.getTeam();
			System.out.println(t.getTeamName());
		}
	}

	@Test
	void TeamRepositoryTest() {
		Team t = new Team();
		t.setTeamId(1);
		t.setTeamName("A팀");
		teamRepository.save(t);
	}
	@Test
	void PlayerRepositoryTest() {
		
		// insert into player values (1, '회원1', 1);

		Team team = new Team();
		team.setTeamId(1);

		Player p = new Player();
		p.setPlayerId(1);
		p.setPlayerName("회원1");
		p.setTeam(team);
		playerRepository.save(p);
	}

	@Autowired
	MajorRepository majorRepository;

	@Test
	void ServiceCenter레파지토리테스트() {
		Major major = new Major();
		major.setName("아무거나");
		major.setEbtbDate(new Date());
		major.setMaxPrsn(30);
		majorRepository.save(major);
	}

	@Test
	void Major엔티티테스트() {
		System.out.println("테스트");
	}

}
