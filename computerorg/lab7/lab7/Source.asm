.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

.data
val1 sword 23
val2 sword -35
val3 sdword 4

.code
main proc
	mov eax, val3
	neg eax
	movsx ebx, val2
	sub eax, ebx
	movsx ebx, val1
	add ebx, ebx
	add ebx, eax

	
	INVOKE ExitProcess,0
main ENDP
END main


