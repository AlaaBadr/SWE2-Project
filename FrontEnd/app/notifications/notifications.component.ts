import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { AlertService } from "../_services/alert.service";
import { GameService } from "../_services/game.service";
import { NotificationService } from "../_services/index";
import { Game } from "../_models/index";
@Component({
   moduleId: module.id,
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
})
export class NotificationsComponent implements OnInit {

  constructor(private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertService,
    private notService: NotificationService,
    private gmService: GameService) { }
  loggedUser: any;
  notifications: Notification[] = [];
  game: Game;
  ngOnInit() {
    this.loggedUser = JSON.parse(localStorage.getItem("currentUser"));
    this.notService.getUserNotifications(this.loggedUser.username).subscribe(data => {
      this.notifications = data;
      console.log("Ach>>>>>", this.notifications);
    }, error => {
      this.alertService.error(error);
    });

  }
  OnClick(link: any) {
    console.log("link>>>>>>>",link);
    this.gmService.getGame(link).subscribe(data => {
      this.game = data;
      console.log("game not>>>>>", this.game);
    }, error => {
      this.alertService.error(error);
    });
    localStorage.setItem("gameName", link);
    this.router.navigate(['/game']);
  }
}
