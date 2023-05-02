.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

.data
array_list byte 10,11,13,18,21,23,24,17,45
index byte 0
sum byte 0

.code
main proc
	mov eax, 0
	mov ebx, 0
	mov ecx, lengthof array_list
	mov edx, 0
	
	

	l1:
		while1:
		movsx esi, index
		CMP index, cl
		jge breaker
		mov al, array_list[esi]
		test al, 1
		jnz bbreaker
		add sum, al
		bbreaker:
			add index, 1
		jmp while1
		breaker:			
	loop l1
	
	INVOKE ExitProcess,0
main ENDP
END main


