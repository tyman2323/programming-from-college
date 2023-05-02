.386
.model flat,stdcall
.stack 4096
ExitProcess PROTO, dwExitCode:DWORD
.code
main PROC
	mov al,245
	mov bl,41
	mov cl,11
	mov dl,215
	sub al,dl
	add dl,cl
	sub dl,bl
	mov al,dl
	invoke ExitProcess, 0
main ENDP
END main