import { INotificacao } from './../../models/notificacao.model';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ContentComponent } from './content.component';
import { NotificationService } from 'src/app/services/notification.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { AppModule } from 'src/app/app.module';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';
import { animate } from '@angular/animations';

describe('ContentComponent', () => {
  let component: ContentComponent;
  let fixture: ComponentFixture<ContentComponent>;
  let notificationService: NotificationService;
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
    notificationService = TestBed.inject(NotificationService);
    fixture.detectChanges();
  });

  it('Should create component', () => {
    expect(component).toBeTruthy();
  });

  it('ngOnInit - Should call carregarNotificacoes method with success', () => {
    const spy = spyOn(component, 'carregarNotificacoes');
    component.ngOnInit();
    expect(spy).toHaveBeenCalled();
  });

  it('lerNotificacao - Should call atualizarLista method with success', () => {
    let notification = MOCK_NOTIFICATIONS;
    spyOn(notificationService, 'editNotificationApi').and.returnValue(of({}));
    const spyLista = spyOn(component, 'atualizarLista');
    component.lerNotificacao(notification[0]);
    expect(spyLista).toHaveBeenCalled();
  });

  it('atualizarLista - Should call carregarNotificacoes method with success', () => {
    const spyCarregar = spyOn(component, 'carregarNotificacoes');
    component.atualizarLista();
    expect(spyCarregar).toHaveBeenCalled();
  });

  it('carregarNotificacoes - Should return values to listaDeNotificacoes with success', () => {
    spyOn(notificationService, 'getNotificationsApi').and.returnValue(
      of(MOCK_NOTIFICATIONS)
    );
    component.carregarNotificacoes();
    expect(component.listaDeNotificacoes.length).toBeGreaterThan(0);
    expect(component.listaDeNotificacoes[0].aplicativo).toEqual('Ifood');
  });

  it('removerNotificacao - Should call atualizarLista method with success', () => {
    component.listaDeNotificacoes = MOCK_NOTIFICATIONS;
    spyOn(component, 'atualizarLista').and.callThrough();
    spyOn(notificationService, 'removeNotification').and.returnValue(of({}));

    spyOn(notificationService, 'getNotificationsApi').and.returnValue(of([]));

    component.removerNotificacao(1);
    expect(component.listaDeNotificacoes.length).toEqual(0);
  });

  const MOCK_NOTIFICATIONS: INotificacao[] = [
    {
      aplicativo: 'Ifood',
      titulo: 'Cupom',
      descricao: 'Receba 10% de desconto',
      tempoPublicacao: '5 dias',
      imagem: 'none',
      lido: false,
      id: 1,
    },
  ];
});
