import { ComponentFixture, TestBed } from "@angular/core/testing"
import { NotificationService } from "./notification.service"
import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing"
import { INotificacao } from "../models/notificacao.model"
import { of } from "rxjs"


describe('NotificationService', () => {
  let component: NotificationService
  let httpMock: HttpTestingController

  beforeEach(async()=>{
    await TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers: [NotificationService]
    }).compileComponents();
    component = TestBed.inject(NotificationService)
    httpMock = TestBed.inject(HttpTestingController)

  })
  it('Should create component', () => {
    expect(component).toBeTruthy();
  });

  it('Should test getNotification', () => {
    spyOn(component, 'getNotifications').and.returnValue(of(MOCK_NOTIFICATION))
    component.getNotifications().subscribe((res) => {
      expect(res).toEqual(MOCK_NOTIFICATION);
    })
  })

  it('Should test getNotificationApi', () =>{
    component.getNotificationsApi().subscribe((res) => {
      expect(res).toEqual(MOCK_NOTIFICATION)
    })
    const req = httpMock.expectOne('http://localhost:3000/notifications');
    expect(req.request.method).toEqual('GET');
    req.flush(MOCK_NOTIFICATION);
  })

  it('Should test addNotificationApi', () => {
    component.addNotificationApi(MOCK_NOTIFICATION[0]).subscribe((res => {
      expect(res).toEqual(MOCK_NOTIFICATION[0])
    }))
    const req = httpMock.expectOne('http://localhost:3000/notifications');
    expect(req.request.method).toEqual('POST')
    req.flush(MOCK_NOTIFICATION[0])
  })

  it('Should test editNotificationApi', () => {
    component.editNotificationApi(MOCK_NOTIFICATION[0]).subscribe((res:INotificacao) => {
      expect(res).toEqual(MOCK_NOTIFICATION[0])
    })
    const req = httpMock.expectOne(`http://localhost:3000/notifications/${MOCK_NOTIFICATION[0].id}`);
    expect(req.request.method).toEqual('PUT')
    req.flush(MOCK_NOTIFICATION[0])
  })

  it('Should test removeNotificationApi', () => {
    component.removeNotification(1).subscribe()
    const req = httpMock.expectOne(`http://localhost:3000/notifications/${MOCK_NOTIFICATION[0].id}`);
    expect(req.request.method).toEqual('DELETE')
  })
  const MOCK_NOTIFICATION: INotificacao[] = [
    {
      aplicativo: 'Ifood',
      titulo: "Cupom",
      descricao: 'Receba 10% de desconto',
      tempoPublicacao: "5 dias",
      imagem: "none",
      lido: false,
      id: 1
    }
  ];
})
