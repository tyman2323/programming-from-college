.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

.data
array word 10, 2, 23, 45, 21, 11 
maximum word ?
.code
main proc
	mov ebx, 0
	mov ecx, lengthof array
	mov edi, 0
	L1:
		mov bx, array[edi]
		cmp bx, maximum
		jg itsgreater
		jmp updater
		itsgreater:
			mov maximum, bx
		
		updater:
			add edi, TYPE array
		loop L1

	
	INVOKE ExitProcess,0
main ENDP
END main


