#include <mega128.h>
#include <delay.h>

void main(void)
{
      DDRB = 0xF0;
      DDRD = 0xF0;
      DDRG = 0x0f;
                       
      PORTB = 0b00110000;
      PORTD = 0b11110000;
while (1)
    {
                PORTB = 0b00000000;
                PORTD = 0b01100000;
                PORTG = 0b00001000;
                delay_ms(5);
                
                 PORTB = 0b01010000;
                 PORTD = 0b10110000;
                PORTG = 0b00000100;
                delay_ms(5);
                
                 PORTB = 0b0011
                 0000;
                PORTD = 0b11110000;                    
                PORTG = 0b00000010;
                delay_ms(5);
                
                 PORTB = 0b00110000;
                PORTD = 0b11110000;
                PORTG = 0b00000001;
                delay_ms(5);       

    }   
             
}