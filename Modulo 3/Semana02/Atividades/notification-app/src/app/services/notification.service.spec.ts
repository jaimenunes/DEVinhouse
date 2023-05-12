import { ComponentFixture, TestBed } from "@angular/core/testing"
import { NotificationService } from "./notification.service"
import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing"


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
})
