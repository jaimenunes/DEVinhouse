import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ContentComponent } from './content.component';
import { NotificationService } from 'src/app/services/notification.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { AppModule } from 'src/app/app.module';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { HttpClient } from '@angular/common/http';

describe('ContentComponent', () => {
  let component: ContentComponent;
  let fixture: ComponentFixture<ContentComponent>;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [ContentComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    }).compileComponents();
    fixture = TestBed.createComponent(ContentComponent);
    component = fixture.componentInstance;
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
});
