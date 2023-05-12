import { INotificacao } from './../../models/notificacao.model';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ContentComponent } from './content.component';
import { NotificationService } from 'src/app/services/notification.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { AppModule } from 'src/app/app.module';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';

describe('ContentComponent', () => {
  let component: ContentComponent;
  let fixture: ComponentFixture<ContentComponent>;
  let notificationService: NotificationService;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [ContentComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
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

  it('lerNotificacao - Should call atualizarLista method with success', () =>{
    let notification = MOCK_NOTIFICATION
    spyOn(notificationService, 'editNotificationApi').and.returnValue(of({}))
    const spyLista = spyOn(component, 'atualizarLista');
    component.lerNotificacao(notification)
    expect(spyLista).toHaveBeenCalled()
  })

  const MOCK_NOTIFICATION: INotificacao = {
      aplicativo: 'Ifood',
      titulo: "Cupom",
      descricao: 'Receba 10% de desconto',
      tempoPublicacao: "5 dias",
      imagem: "none",
      lido: false
  }
});
