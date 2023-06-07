import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ContentComponent } from './content.component';
import { NotificationService } from 'src/app/services/notification.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { AppModule } from 'src/app/app.module';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NOTIFICATIONS_MOCK } from 'src/app/utils/notifications-mock';
import { of } from 'rxjs/internal/observable/of';

describe('ContentComponent', () => {
  let component: ContentComponent;
  let fixture: ComponentFixture<ContentComponent>;
  const notificationService = jasmine.createSpyObj(NotificationService, [
    'getNotifications',
    'editNotificationApi',
    'removeNotification',
  ]);
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [ContentComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
      providers: [
        { provide: NotificationService, useValue: notificationService },
      ],
    }).compileComponents();
    fixture = TestBed.createComponent(ContentComponent);
    component = fixture.componentInstance;
  });

  it('Should create component', () => {
    expect(component).toBeTruthy();
  });

  it('ngOnInit - Should call carregarNotificacoes method with success', () => {
    const spy = spyOn(component, 'carregarNotificacoes');
    component.ngOnInit();
    expect(spy).toHaveBeenCalled();
  });

  it('Carregar notificações', () => {
    notificationService.getNotifications.and.returnValue(
      of(NOTIFICATIONS_MOCK)
    );
    component.carregarNotificacoes();
  });
});
