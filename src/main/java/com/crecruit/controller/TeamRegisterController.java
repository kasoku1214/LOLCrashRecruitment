package com.crecruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crecruit.entity.Summoner;
import com.crecruit.entity.Team;
import com.crecruit.service.TeamRegisterService;
import com.crecruit.utility.MessageText;

@Controller
public class TeamRegisterController {

	@Autowired
	TeamRegisterService teamRegisterService;

	@Autowired
	TeamSearchController teamSearchController;

	/**
     * 登録用Teamオブジェクトを初期化して返却する
     * @return 登録用Teamオブジェクト
     */
    @ModelAttribute("team")
    public Team CreateTeamForRegister(){
    	// Teamを生成
        Team team = new Team();
        return team;
    }

    /**
	 * エラーメッセージ表示判定オブジェクトを初期化して返却する
	 * @ruturn エラーメッセージ表示判定オブジェクト
	 */
	@ModelAttribute("messageText")
	public MessageText createMessageText() {
		MessageText messageText = new MessageText();
		return messageText;
	}

	@RequestMapping(value = "/open_team_register")
	public ModelAndView openRegisterTeamPage(ModelAndView modelAndView) {

		// チーム登録画面に遷移
		modelAndView.setViewName("team_register");

		return modelAndView;
	}

	@RequestMapping(value = "/team_register")
	public String registerTeam(ModelAndView modelAndView, Team team, RedirectAttributes redirectAttributes) {

		// 登録するサモナーリスト
		List<Summoner> summonerList =new ArrayList<Summoner>();

		// チームメンバー内のサモナーネームが空欄ではないサモナーをリストに追加
		for (Summoner summoner : team.getSummonerList()) {
			if (!summoner.getSummonerName().equals("")) {
				summonerList.add(summoner);
			}
		}

		// チームに登録するサモナーリストを設定する
		team.setSummonerList(summonerList);

		// チームとメンバーを登録
		teamRegisterService.createTeam(team);

		// 募集完了メッセージ格納（リダイレクト先に値を渡している）
		redirectAttributes.addFlashAttribute("messageText", new MessageText("募集が完了しました。", "success"));

		return "redirect:/";
	}
}
